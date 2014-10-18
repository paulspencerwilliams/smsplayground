smsplayground
=============

cucumber-jvm driving retrofit driving grape driving sequel driving postgresql

Clone repo `git clone git@github.com:paulspencerwilliams/smsplayground.git`

To get working, install postgresql (using vagrant maybe ;-) )

Then, `bundle install` and `rackup` to run restful webservice on 9292

Then `brew install maven` and configure it to use java 1.7 http://stackoverflow.com/questions/18813828/why-maven-use-jdk-1-6-but-my-java-version-is-1-7

Then `mvn test` should pass
