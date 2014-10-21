require "sequel"

Sequel.migration do
  change do
    create_table(:positions) do
      primary_key :id
      Integer :user_id, :null=>false
      Numeric :latitude, :null=>false
      Numeric :longitude, :null=>false
    end
  end
end
