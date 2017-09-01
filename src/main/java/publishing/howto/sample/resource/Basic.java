package publishing.howto.sample.resource;

import static java.lang.System.getenv;
import static java.util.Arrays.asList;
import static java.util.Collections.list;
import static java.util.stream.Collectors.joining;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/")
public class Basic {

    private final String SCHENV = Optional.ofNullable(getenv("SCHENV")).orElse("?");

    @GET
    @Produces(TEXT_PLAIN)
    public String req(@Context HttpServletRequest request) {
        final String env = getenv().entrySet().stream()
                .map(Entry::toString).sorted()
                .collect(joining("\n"));
        final String headers = list(request.getHeaderNames()).stream()
                .map(name -> new SimpleEntry(name, request.getHeader(name)))
                .map(Entry::toString)
                .sorted()
                .collect(joining("\n"));
        final String params = request.getParameterMap().entrySet().stream()
                .map(e -> new SimpleEntry(e.getKey(), Arrays.toString(e.getValue())))
                .map(Entry::toString)
                .sorted()
                .collect(joining("\n"));
        return String.join("\n\n", asList("Hello I'm running as '" + SCHENV + "' and here's most of my environment:", headers, params, env));
    }
}
