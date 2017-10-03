### Step 0: Getting the basics in place

1. Unless you already have git, install it e.g. `brew install git`
2. `git clone` this repository
3. `cd 001-sample-java`

### Step 1: Deployin' time

1. Locally
   1. **Prerequisites:** `brew install maven heroku`
   2. **Setup:** `mvn package`
   3. **Deploy:** `heroku local`
   4. **Test:** [http://127.0.0.1:8090](http://127.0.0.1:8090)
2. Heroku (git)
   1. **Prerequisites:** A Heroku.com account
   2. **Setup:** `heroku create <appname> --region eu`
   3. **Deploy:** `git push heroku master`
   4. **Test:** `https://<appname>.herokuapp.com`
3. Heroku (Docker)
   1. **Prerequisites:** Docker installed & running on your machine
   2. **Setup:** `heroku container:login`
   3. **Deploy:** `heroku container:push web`
   4. **Test:** `https://<appname>.herokuapp.com`
4. Convox
   1. **Prerequisites:**
      * A Convox.com account
      * [Install Convox in your AWS account](https://convox.com/docs/installing-a-rack/)
      * [Install Convox CLI](https://convox.com/docs/installation/)
      * [Create a Rack](https://convox.com/docs/installing-a-rack/)
      * `convox login`
         * _Connects your CLI to your account_
      * `convox switch <account>/<rack>`
         * _Makes this the default Rack for your CLI_
   2. **Setup:** `convox apps create <appname>`
   3. **Deploy:** `convox deploy --app <appname>`
      * _Get a :coffee: while the first deploy sets up the app and propagates the DNS records_
   4. **Test:** `https://<appname>-<processname>-<something>.<awsregion>.elb.amazonaws.com`
