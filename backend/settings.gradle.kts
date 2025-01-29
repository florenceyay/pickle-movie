rootProject.name = "backend"

include("services:MovieDataService")
include("services:UserService")

// Explicitly set project directories
project(":services:MovieDataService").projectDir = file("services/MovieDataService")
project(":services:UserService").projectDir = file("services/UserService")
