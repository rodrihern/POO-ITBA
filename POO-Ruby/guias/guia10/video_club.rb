# frozen_string_literal: true
require_relative 'customer'
require_relative 'movie'


class VideoClub
  def initialize
    @movies = Hash.new
    @customers = Hash.new
  end

  def add_movie(title, category)
    @movies[title] = Movie.new(title, category)
  end

  def add_customer(name)
    @customers[name] = Customer.new(name)
  end

  def rent(title, name, days)
    raise 'no such movie' unless @movies.has_key?(title)
    raise 'no such customer' unless @customers.has_key?(name)
    @customers[name].add_points(@movies[title].category.points(days))
    @customers[name].add_charge(@movies[title].category.charge(days))
  end

  def resume(customer_name)
    raise 'customer not found' unless @customers.has_key?(customer_name)
    customer = @customers[customer_name]
    "Resume points:#{customer.points}, charge:#{customer.charge}"
  end

end
