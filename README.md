# springboot-mongodb-task
* spring boot 4.17.1
* mongo atlas

# API example

### GetMapping
* http://localhost:8080/tasks
* http://localhost:8080/tasks/0fd38171
* http://localhost:8080/tasks/severity/3
* http://localhost:8080/tasks/assignee/ominomin

### PostMapping
* http://localhost:8080/tasks
'''
{
    "description" : "today's to-do to have to do",
    "severity": 3,
    "assignee" : "ominomin",
    "storyPoint" : 10
}
'''

### PutMapping
* http://localhost:8080/tasks
'''
{
    "taskId": "b7707cec",
    "description": "today's to-do to have to do",
    "severity": 6,
    "assignee": "ominomin",
    "storyPoint": 15
}
'''

### DeleteMapping
* http://localhost:8080/tasks/b7707cec

