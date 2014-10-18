Feature: As an api consumer, I want to be able to register my position, to enable the system to find proximity matches between me and others

  Scenario: Registering at Tamworth
    When I register my position
    Then the system will record my position