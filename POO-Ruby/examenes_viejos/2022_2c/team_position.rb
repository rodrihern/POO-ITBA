# frozen_string_literal: true
require_relative 'team'

class TeamPosition
  include Comparable

  def initialize(team)
    @team = team
    @points = @gf = @gc = 0
  end

  def <=>(other)
    return nil unless other.is_a?(TeamPosition)
     [other.points, other.gf - other.gc, other.gf, @team.country] <=> [@points, @gf - @gc, @gf, other.team.country]
  end

  def to_s
    "#{@team.country}\t#{@points}\t#{@gf}\t#{@gc}\n"
  end

  attr_accessor :team, :points, :gf, :gc
end
