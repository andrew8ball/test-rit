package net.andr.services;

import com.google.gson.Gson;
import net.andr.dto.site.SearchResponseDto;
import net.andr.dto.stackExchange.ApiResponseDto;
import net.andr.dto.stackExchange.ItemDto;
import net.andr.mapper.SearchMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

@Service
public class StackExchangeService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Value("${se.questions.url}")
    private String stackExchangeQuestionsUrl;
    @Value("${se.answers.url}")
    private String stackExchangeAnswersUrl;

    @Autowired
    private SearchMapper searchMapper;
    @Autowired
    private Gson gson;

    public SearchResponseDto search(final Set<String> tags) {
        try {
            String url = createQuestionsApiUrl(tags);
            String response = request(url);
            final ApiResponseDto questionsResponseDto = gson.fromJson(response, ApiResponseDto.class);

            List<Long> acceptedAnswersIds = getAcceptedAnswerIds(questionsResponseDto);
            url = createAnswersApiUrl(acceptedAnswersIds);
            response = request(url);
            final ApiResponseDto answersResponseDto = gson.fromJson(response, ApiResponseDto.class);

            return searchMapper.foo(questionsResponseDto, answersResponseDto);
        } catch (Exception ex) {
            log.error("Search", ex);
            throw new InternalError(ex);
        }
    }

    private List<Long> getAcceptedAnswerIds(final ApiResponseDto apiResponse) {
        return apiResponse
                .getItems()
                .stream()
                .filter(itemDto -> itemDto.getAcceptedAnswerId() != null)
                .map(ItemDto::getAcceptedAnswerId)
                .collect(Collectors.toList());
    }

    private String request(final String url) throws IOException {
        URLConnection connection = new URL(url).openConnection();
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(new GZIPInputStream(connection.getInputStream())))) {
            return reader.lines().collect(Collectors.joining());
        }
    }

    private String createQuestionsApiUrl(final Set<String> tags) {
        return String.format(stackExchangeQuestionsUrl, String.join(";", tags));
    }

    private String createAnswersApiUrl(final List<Long> ids) {
        return String.format(
                stackExchangeAnswersUrl,
                ids.stream().map(Object::toString).collect(Collectors.joining("%3B"))
        );
    }
}
