### Step 0: Getting the basics in place

1. Unless you already have git, install it e.g. `brew install git`
2. `git clone git@github.schibsted.io:spt-pub-infra-howto/001-sample-java.git`
3. `cd 001-sample-java`

### Step 1: Deployin' time
| | 1.1: Locally | 1.2: Heroku git | 1.3: Heroku Docker | 1.4: Convox |
|---------------|---|---|---|---|
| **Prerequisites** | `brew install maven heroku` | A Heroku.com account | Docker installed & running on your machine | An AWS account |
| | | | | A Convox.com account |
| | | | | [Install Convox in your AWS account](https://convox.com/docs/installing-a-rack/) |
| | | | | [Install Convox CLI](https://convox.com/docs/installation/) |
| | | | | [Create a Rack](https://convox.com/docs/installing-a-rack/) |
| | | | | `convox login` |
| | | | | `convox switch <account>/<rack>` |
| **Setup**         | `mvn package`  | `heroku create <appname> --region eu` | `heroku container:login` | `convox apps create <appname>` |
| **Deploy**        | `heroku local`  | `git push heroku master` | `heroku container:push web` | `convox deploy --app <appname>` <sup>_(get a coffe while the first deploy sets up the app and propagates the DNS records)_</sup> |
| **Test**          | [http://127.0.0.1:8090](http://127.0.0.1:8090) | `https://<appname>.herokuapp.com` | `https://<appname>.herokuapp.com` | `https://<appname>-<processname>-<something>.<awsregion>.elb.amazonaws.com` |
