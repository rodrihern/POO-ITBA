# frozen_string_literal: true
require_relative 'movie_category'

class Movie
  attr_reader :category

  def initialize(title, category)
    @title = title
    @category = category
  end
end
