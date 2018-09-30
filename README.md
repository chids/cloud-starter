### About
This is basic tutorial and showcase for how to take a basic HTTP API written in Java and run it; first locally, then on Heroku by pushing code, then on Heroku using Docker and finally on AWS by leveraging [Convox](https://convox.com).

The tutorial was written from the persective of being on MacOS and having [Homebrew](https://brew.sh) installed.

### Step 0: Getting the basics in place

1. Unless you already have git, install it (e.g. `brew install git`)
2. `git clone` this repository
3. `cd cloud-starter`
4. Install Maven and the Heroku CLI (e.g. `brew install maven heroku`)
5. Compile and package the application by running: `mvn package`

### Step 1: Deployin' time

#### Locally
_Estimated time to complete this section: 30 seconds_

1. **Deploy:** `heroku local`
   * _Estimated deployment time: 1 second_
2. **Test:** [http://127.0.0.1:8090](http://127.0.0.1:8090)

#### Heroku (git)
_Estimated time to complete this section: 5 minutes_

1. **Prerequisites:** A Heroku.com account
2. **Setup:** `heroku create <appname> --region eu`
3. **Deploy:** `git push heroku master`
   * _Estimated deployment time: 15 seconds_
4. **Test:** `https://<appname>.herokuapp.com`

#### Heroku (Docker)
_Estimated time to complete this section: 10 minutes_

1. **Prerequisites:** Docker installed & running on your machine
2. **Setup:** `heroku container:login`
3. **Deploy:** `heroku container:push web`
   * _Estimated deployment time: 15 seconds_
4. **Test:** `https://<appname>.herokuapp.com`

#### Convox
_Estimated time to complete this section: 25 minutes_

1. **Prerequisites:**
   * A Convox.com account
   * [Install Convox in your AWS account](https://convox.com/docs/installing-a-rack/)
      * _Make sure you create a Rack as part of the installation_
   * [Install the Convox CLI](https://convox.com/docs/installation/)
   * `convox login`
      * _This connects the CLI to your account_
   * `convox switch <account>/<rack>`
      * _This sets the default Rack for your CLI_
2. **Setup:** `convox apps create <appname> --wait`
3. **Deploy:** `convox deploy --app <appname> --wait`
   * _Estimated deployment time: 3 minutes_
   * _Get a :coffee: while the first deploy sets up the app and propagates the DNS records_
4. **Test:** `https://<appname>-<processname>-<something>.<awsregion>.elb.amazonaws.com`
   * _The DNS endpoint is displayed by:_ `convox services --app <appname>`