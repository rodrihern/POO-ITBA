# frozen_string_literal: true
require_relative 'team_position'

class WorldCup

  def initialize
    @groups = {}
  end

  def add_team(group, team)
    @groups[group] = {} unless @groups.key?(group)
    @groups[group][team] = TeamPosition.new(team)
  end

  def play_match(group, team1, team2, goals1, goals2)
    raise 'Missing Group' unless @groups.key?(group)
    raise 'Missing Team' unless @groups[group].key?(team1) && @groups[group].key?(team2)
    @groups[group][team1].gf += goals1
    @groups[group][team1].gc += goals2
    @groups[group][team1].gf += goals2
    @groups[group][team1].gc += goals1
    winning_team = nil
    if goals1 > goals2
      winning_team = team1
    elsif goals2 > goals1
      winning_team = team2
    end
    if winning_team.nil?
      @groups[group][team1].points += 1
      @groups[group][team2].points += 2
    else
      @groups[group][winning_team].points += 3
    end
  end


  # def to_s
  #   s = "World Cup\n"
  #   @groups.keys.sort.each do |group|
  #     s += "#{group}\nTeam\tP\tGF\tGC\n"
  #     @groups[group].values.sort.each { |team_position| s += team_position.to_s}
  #   end
  #   s
  # end

  def to_s
    @groups.keys.sort.reduce("World Cup\n") { |str, group| str + @groups[group].values.sort.reduce("#{group}\nTeam\tP\tGF\tGC\n") { |s, e| s + e.to_s}}
  end



end

