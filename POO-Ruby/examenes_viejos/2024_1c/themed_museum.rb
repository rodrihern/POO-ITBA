# frozen_string_literal: true
require_relative 'museum'

class ThemedMuseum < Museum
  def add_exhibition(themed_pavilion, name, theme)
    raise 'Theme does not match' unless theme == themed_pavilion.theme
    super
  end
end
