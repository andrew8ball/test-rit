package net.andr.mapper;

import net.andr.dto.site.QuestionDto;
import net.andr.dto.site.SearchResponseDto;
import net.andr.dto.site.UserDto;
import net.andr.dto.stackExchange.ApiResponseDto;
import net.andr.dto.stackExchange.ItemDto;
import net.andr.dto.stackExchange.OwnerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SearchMapper {
    public SearchResponseDto foo(final ApiResponseDto questionResponse, final ApiResponseDto answerResponse) {
        final SearchResponseDto searchResponseDto = new SearchResponseDto();
        searchResponseDto.setHasMore(questionResponse.getHasMore());
        searchResponseDto.setQuotaMax(questionResponse.getQuotaMax());
        searchResponseDto.setQuotaRemaining(questionResponse.getQuotaRemaining());
        List<QuestionDto> question = questionResponse
                .getItems()
                .stream()
                .map(itemDto -> this.fromQuestionAnswers(itemDto, answerResponse.getItems()))
                .collect(Collectors.toList());
        searchResponseDto.setQuestions(question);
        return searchResponseDto;
    }

    private QuestionDto fromQuestionAnswers(final ItemDto question, final List<ItemDto> answers) {
        final QuestionDto questionForTable = new QuestionDto();
        questionForTable.setLink(question.getLink());
        questionForTable.setAccepted(false);
        questionForTable.setBodyQuestion(question.getBody());
        questionForTable.setTitle(question.getTitle());
        questionForTable.setAuthor(fromOwner(question.getOwner()));
        if (question.getAcceptedAnswerId() != null) {
            Optional<ItemDto> acceptedAnswer = findAnswerById(question.getAcceptedAnswerId(), answers);
            acceptedAnswer.ifPresent(itemDto -> {
                questionForTable.setBodyAnswer(itemDto.getBody());
                questionForTable.setRespondent(fromOwner(itemDto.getOwner()));
                questionForTable.setAccepted(true);
            });
        }
        return questionForTable;
    }

    private Optional<ItemDto> findAnswerById(final long id, final List<ItemDto> answerItems) {
        return answerItems.stream().findFirst().filter(itemDto -> itemDto.getAnswerId() == id);
    }

    private UserDto fromOwner(final OwnerDto ownerDto) {
        final UserDto userDto = new UserDto();
        userDto.setLink(ownerDto.getLink());
        userDto.setLinkImage(ownerDto.getProfileImage());
        userDto.setName(ownerDto.getDisplayName());
        userDto.setReputation(ownerDto.getReputation());
        return userDto;
    }
}
