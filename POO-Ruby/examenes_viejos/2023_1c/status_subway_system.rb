# frozen_string_literal: true
require_relative 'status_subway_station'
require_relative 'subway_system'

class StatusSubwaySystem < SubwaySystem
  def initialize(name)
    super
  end

  private def build_station(station_name)
    StatusSubwayStation.new(station_name)
  end
end
