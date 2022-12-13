from sqlalchemy import null


class process():
    def __init__(self, ID, file_name):
        self.ID = ID
        self.state = "ready"
        self.temp = null
        self.IR = ""
        self.ACC = null
        self.PC = 0
        self.INST = open(file_name).readlines()

    def run(self):
        ""
    def unblock(self):
        ""
    def show_context(self):
        ""

while True : 
    ""