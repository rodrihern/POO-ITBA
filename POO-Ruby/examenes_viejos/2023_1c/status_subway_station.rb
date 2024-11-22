# frozen_string_literal: true
require_relative 'subway_station'

class StatusSubwayStation < SubwayStation
  def initialize(name)
    super
    @is_open = true
  end

  def open_station
    @open = true
  end


  def close_station
    @open = false
  end


  def to_s
    "#{super} is #{@open ? 'Open' : 'Closed'}"
  end



end
