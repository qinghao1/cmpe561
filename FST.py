class State:
	#Transition list is a list of tuples of (input, output, next_state)
	def __init__(self, state_num):
		self.state_num = state_num
		#self.transition is a hashmap of input -> (output, next_state)
		self.transition = {}
	def add_transition(self, _input, _output, next_state):
		self.transition[input] = (_output, next_state)

class FST:
	def __init__(self):
		self.states = {}
	def add_arc(self, state1, state2, _input, _output):
		if not state1 in self.states:
			self.states[state1] = State(state1)
		if not state2 in self.states:
			self.states[state2] = State(state2)
		self.states[state1].add_transition(_input, _output, state2)
	def feed(self, string):
		current_state = self.states[0] #Start state TODO
		for char in string:
			print(current_state.transition('c'))
			output_tuple = current_state.transition[char]
			print(output_tuple(0))
			current_state = states[output_tuple[1]]


f = FST()
f.add_arc(0, 1, 'c', 'c')
f.add_arc(1, 2, 'a', 'u')
f.add_arc(2, 3, 't', 't')
f.feed("cat")