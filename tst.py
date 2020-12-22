input="om leads Mary"


mapManger={key,[]}

for x in input.split():
    myDict(x[0],x[2])


def myDict(employee,manager):
    mapManger[employee]=manager

def findBoss(emp1,emp2):
    manger=mapManger[emp1]
    if(mapManger[emp1]==mapManger[emp2]):
        return mapManger[emp1][0]
    
    
