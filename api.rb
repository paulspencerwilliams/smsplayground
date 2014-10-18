require 'grape'

module SMSPlayground
  class API < Grape::API
    format :json
    resource :users do

      desc "User positions etc"
      params do
        requires :id, type: Integer, desc: "User id."
      end
      route_param :id do
        put :position do
          'hello'
        end
      end

    end
  end
end
