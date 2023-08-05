Feature: validate Get request

	
	Scenario: 2.Validate Demo QA up and running
    Given hit the URI
    Then validate value for below data
    | books[0].title     | Git Pocket Guide                    |
    | books[0].pages     | 234                                 |
    | books[0].author    | Richard E. Silverman                |
    | books[0].publisher | O'Reilly Media                      |
    | books[1].title     | Learning JavaScript Design Patterns |
    