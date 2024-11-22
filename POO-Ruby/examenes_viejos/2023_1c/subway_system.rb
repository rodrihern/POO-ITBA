# frozen_string_literal: true
require_relative 'subway_line'
require_relative 'subway_station'
require_relative 'status_subway_station'
require 'sorted_set'

class SubwaySystem
  def initialize(name)
    @name = name
    @stations_by_line = {}
  end

  def add_station(line_letter, station_name)
    line = build_line(line_letter)
    @stations_by_line[line] = SortedSet.new unless @stations_by_line.key?(line)
    station = build_station(station_name)
    @stations_by_line[line] << station
    station
  end

  def lines
    @stations_by_line.keys
  end

  def stations(line_letter)
    @stations_by_line[build_line(line_letter)]
  end

  private

  def build_line(line_letter)
    SubwayLine.new(line_letter)
  end

  def build_station(station_name)
    SubwayStation.new(station_name)
  end

end
