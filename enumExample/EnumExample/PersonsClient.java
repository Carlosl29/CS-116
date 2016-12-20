public class PersonsClient 
{
	public static void main(String[] args) 
	{
		
		Persons p1=new Persons();
		Persons p2=new Persons();
		p1.setPersonType(PersonType.ADULT_FEMALE);
		p2.setPersonType(PersonType.CHILD_MALE);
		System.out.println("p1 is of person type:"+" "+p1.getPersonType());
		System.out.println("p2 is of person type:"+" "+p2.getPersonType());
		
	}
}
