require 'grape'
require 'sequel'

Sequel::Model.plugin(:schema)
DB = Sequel.postgres('smsplayground',
                     :user=>'smsplayground',
                     :password=>'itsasecret',
                     :host=>'localhost',
                     :port=>5432,
                     :max_connections=>10)

class Position < Sequel::Model(:positions)
end


I18n.enforce_available_locales = false
module SMSPlayground
  class API < Grape::API
    format :json
    namespace 'users/:userid' do
      resource :position do
        put do
          Position.create({:user_id => params[:userid],
                           :latitude => params[:latitude],
                           :longitude => params[:longitude]})
        end
      end

    end
  end
end
