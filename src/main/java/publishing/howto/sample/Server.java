package publishing.howto.sample;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import publishing.howto.sample.resource.Basic;

public class Server extends Application<Configuration> {

    @Override
    public void initialize(final Bootstrap<Configuration> bootstrap) {}

    @Override
    public void run(final Configuration configuration, final Environment environment) throws Exception {
        environment.jersey().register(new Basic());
    }

    public static void main(final String[] args) throws Exception {
        new Server().run(args);
    }
}
