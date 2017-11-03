import java.util.ArrayList;
import java.util.HashMap;

public class FST {
	class Pair<T1, T2> {
		T1 k; T2 v;
		Pair(T1 _k, T2 _v) {
			k = _k;
			v = _v;
		}
		T1 getKey() {
			return k;
		}
		T2 getValue() {
			return v;
		}
	}
	
    class State {
        int state_number;
        HashMap<Character, Pair<Character, Integer>> transitions = new HashMap<>();

        State(int _state_number) {
            state_number = _state_number;
        }

        void add_transition(char i, char o, int nxt) {
//        	System.out.println(i);
//        	System.out.println(o);
//        	System.out.println(nxt);
            transitions.put(i, new Pair(o, nxt));
        }
    }

    HashMap<Integer, State>stateList = new HashMap<>();

    void add_arc(int _state1, int _state2, char i, char o) {
    	State state1, state2;
        if (stateList.containsKey(_state1)) {
        	state1 = stateList.get(_state1);
        } else {
        	state1 = new State(_state1);
        	stateList.put(_state1, state1);
        }
        if (stateList.containsKey(_state2)) {
        	state2 = stateList.get(_state2);
        } else {
        	state2 = new State(_state2);
        	stateList.put(_state2, state2);
        }
        state1.add_transition(i, o, _state2);
    }

    void feed(String s) {
        State current_state = stateList.get(0);
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            Pair<Character, Integer> current_state_transition = current_state.transitions.get(c);
            System.out.println(current_state_transition.getKey());
            current_state = stateList.get(current_state_transition.getValue());
        }
    }

    public static void main(String[] args) {
        FST f = new FST();
        f.add_arc(0, 1, 'c', 'c');
        f.add_arc(1, 2, 'a', 'u');
        f.add_arc(2, 3, 't', 't');
        f.feed("cat");
    }
}
