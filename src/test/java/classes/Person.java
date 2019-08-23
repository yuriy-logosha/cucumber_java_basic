package classes;

public class Person {
	private String name;
	private String surname;
	private String job;
	private String dob;
	private String languageString;
	private String gender;
	private String employeeStatus;
	
	public Person() {
		super();
	}
	
	public Person(String name, String surname, String job, String dob, String languageString, String gender,
			String employeeStatus) {
		super();
		setName(name);
		setSurname(surname);
		setJob(job);
		setDob(dob);
		setLanguageString(languageString);
		setGender(gender);
		setStatus(employeeStatus);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setLanguageString(String rawLangs) {
		this.languageString = rawLangs;
	}
	
	public String getLanguageString() {
		return this.languageString;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getStatus() {
		return employeeStatus;
	}
	
	public void setStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person persObj = (Person) obj;
			
			boolean equalExceptLangs = this.getName().equals(persObj.getName()) &&
					this.getSurname().equals(persObj.getSurname()) &&
					this.getJob().equals(persObj.getJob()) &&
					this.getDob().equals(persObj.getDob()) &&
					this.getGender().equals(persObj.getGender()) &&
					this.getStatus().equals(persObj.getStatus());
			if(!equalExceptLangs) {
				return false;
			}
			
			String[] thisLangs = this.getLanguageString().split("\\p{javaSpaceChar}*,\\p{javaSpaceChar}*");
			String[] thatLangs = persObj.getLanguageString().split("\\p{javaSpaceChar}*,\\p{javaSpaceChar}*");
			
			boolean langsEqual = thisLangs.length == thatLangs.length;
			if(!langsEqual) {
				return false;
			}
			
			int matches = 0;
			for(String s : thisLangs) {
				for(String t : thatLangs) {
					if(s.equalsIgnoreCase(t)) {
						matches++;
					}
				}
			}
			return (matches == thisLangs.length);
		}
		return super.equals(obj);
	}
}
