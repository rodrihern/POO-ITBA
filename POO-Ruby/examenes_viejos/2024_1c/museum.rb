# frozen_string_literal: true
require_relative 'pavilion'
require_relative 'exhibition'

class Museum
  def initialize
    @exhibitions = Hash.new
  end

  def add_exhibition(pavilion, name, theme)
    @exhibitions[pavilion] = [] unless @exhibitions.key?(pavilion)
    raise 'Cannot add exhibition' unless @exhibitions[pavilion].length < pavilion.cap
    @exhibitions[pavilion] << Exhibition.new(name, theme)
  end

  def pavilion_exhibits(pavilion)
    @exhibitions[pavilion]
  end

  def pavilions
    @exhibitions.keys
  end

end
