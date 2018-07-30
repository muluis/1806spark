package com.exercise;

public class Gym extends Member {

		
	
	public String clubMember;
	private int exerciseLength;
	private int lengthOpen;
	
		
		public Gym() {
			
		}


		public Gym(String clubMember, int exerciseLength, int lengthOpen) {
			super();
			this.clubMember = clubMember;
			this.exerciseLength = exerciseLength;
			this.lengthOpen = lengthOpen;
		}


		public String getClubMember() {
			return clubMember;
		}


		public void setClubMember(String clubMember) {
			this.clubMember = clubMember;
		}


		public int getExerciseLength() {
			return exerciseLength;
		}


		public void setExerciseLength(int exerciseLength) {
			this.exerciseLength = exerciseLength;
		}


		public int getLengthOpen() {
			return lengthOpen;
		}


		public void setLengthOpen(int lengthOpen) {
			this.lengthOpen = lengthOpen;
		}


		@Override
		public String toString() {
			return "Gym [clubMember=" + clubMember + ", exerciseLength=" + exerciseLength + ", lengthOpen=" + lengthOpen
					+ "]";
		};
		
}
		
		