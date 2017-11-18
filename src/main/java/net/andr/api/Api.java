package net.andr.api;

import net.andr.dto.site.SearchResponseDto;
import net.andr.services.StackExchangeService;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class Api {
    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
    private final Set<String> tags = new LinkedHashSet<>();
    @Autowired
    private StackExchangeService stackExchangeService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public DeferredResult<SearchResponseDto> search(@RequestParam(value = "tags") String searchTags) {
        log.error("FUCK");
        tags.addAll(formatTags(searchTags));
        return research();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public DeferredResult<SearchResponseDto> remove(@RequestParam(value = "tags") String searchTags) {
        if (searchTags.trim().isEmpty()) return null;
        tags.removeAll(formatTags(searchTags));
        return research();
    }

    private DeferredResult<SearchResponseDto> research() {
        final DeferredResult<SearchResponseDto> result = new DeferredResult<>();
        if (tags.isEmpty()) return null;
        SearchResponseDto search = stackExchangeService.search(tags);
        search.setTags(tags);
        result.setResult(search);
        return result;
    }

    private Set<String> formatTags(final String tags) {
        String[] split = tags.trim().toLowerCase().split(",");
        return new HashSet<>(Arrays.asList(split));
    }

}
