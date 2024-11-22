# frozen_string_literal: true
require_relative 'section'
require_relative 'table'
require 'sorted_set'

class Restaurant
  def initialize(name)
    @name = name
    @tables = Hash.new
  end

  def add_table(section, name, capacity)
    table = Table.new(name, capacity, section.name)
    @tables[section] = SortedSet.new unless @tables.key?(section)
    @tables[section] << table unless @tables[section].include?(table)
  end

  def tables(section)
    raise ArgumentError.new('Section does not exist') unless @tables.key?(section)
    @tables[section]
  end

  def sections_count
    @tables.length
  end

  def tables_count(section)
    tables(section).size
  end

end
