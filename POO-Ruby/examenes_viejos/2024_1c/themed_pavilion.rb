# frozen_string_literal: true
require_relative 'pavilion'

class ThemedPavilion < Pavilion
  def initialize(name, cap, theme)
    super(name, cap)
    @theme = theme
  end

  def to_s
    "#{@theme} Themed #{super}"
  end

  attr_reader :theme
end
