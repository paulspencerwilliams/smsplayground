sudo apt-get update
curl -L https://get.rvm.io | bash -s stable --ruby
source /home/vagrant/.rvm/scripts/rvm
sudo apt-get install postgresql -y
sudo apt-get install libpq-dev -y
cd /vagrant/server/
bundle install
sudo -u postgres   createuser -P -d -S smsplayground
sudo service postgres restart
 createdb -U smsplayground -W smsplayground
sequel -m db/migrations/ postgres://smsplayground:itsasecret@localhost:5432/smsplayground
rackup

sudo apt-get install maven -y
sudo apt-get install openjdk-7-jdk -y
