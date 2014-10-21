sudo apt-get update
curl -L https://get.rvm.io | bash -s stable --ruby
source /home/vagrant/.rvm/scripts/rvm
sudo apt-get install postgresql
cd /vagrant/server/
bundle install
sequel -m db/migrations/ postgres://smsplayground:itsasecret@localhost:5432/smsplayground
rackup

