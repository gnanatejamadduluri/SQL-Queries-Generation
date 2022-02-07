package gnanaPractice;
import java.util.Scanner;

public class check {
	
public static void main(String[] args) {
	try {
	Scanner s1= new Scanner(System.in);
	System.out.println("     WELCOME TO THE QUERY GENERATION ZONE \n          (UPDATE, DELETE,SELECT) \n Please follow the step by step instructions correctly to avoid errors\n Please select from the below options");
	System.out.println("enter:\n '1' for Update Query\n '2' for Delete Query\n '3' To get ',' seperated values to use BULK values for extracting in where conditions, in SQL\n '4' for the 'select' Query(including joins)");
	int I=s1.nextInt();
	
	if (I==1) {System.out.println("UPDATE QUERY\n\nSyntax: UPDATE table_name\r\n"
			+ "SET column1 = value1, column2 = value2, ...\r\n"
			+ "WHERE condition;");updateQuery();}
	else if (I==2) {System.out.println("DELETE QUERY\\nnSyntax: DELETE FROM table_name WHERE condition;");deleteQuery();}
	else if (I==3) {System.out.println("Enter total number of values: "); queryHelp();}
	else if (I==4) {selectQuery();}	
	else {System.out.println("Please enter a valid Input");}
	System.exit(0);
	}
	catch(Exception e){System.out.println("error: Exited due to wrong input");System.exit(0);
	}
}

	
static void updateQuery() {
	Scanner s1= new Scanner(System.in);
	System.out.println("\nPlease enter the table name: ");
	String u1 =s1.nextLine();
	System.out.println("Please enter the column-name to  update: ");
	String u2 =s1.nextLine();
	System.out.println("Please enter the base column-name used for the update: ");
	
	String u3 =s1.nextLine();
	System.out.println("Please enter the no.of values to update: ");
	int u4 = s1.nextInt();
	String u11[]= new String[u4]; String u22[]=new String[u4];
	System.out.println("Please enter the values to update: ");
	Scanner s2= new Scanner(System.in);
	for (int i=0;i<u4;i++) {
	u11[i]	= s2.nextLine();
	}
	System.out.println("\n Please enter the base-column values used  to update(same as update values sequence): ");
	for (int j=0;j<u4;j++) {
	u22[j]	= s2.nextLine();
	}
	for (int k=0;k<u4;k++) {
		System.out.println("update " +u1+ " set " +u2+ "='"+u11[k]+"' where " +u3+ "='"+u22[k]+"';" );
	}
}
static void deleteQuery() {
	Scanner s1= new Scanner(System.in);
	System.out.println("Please enter the table name: ");
	String u1 =s1.nextLine();
	System.out.println("Please enter the base column-name used to delete the row: ");
	String u3 =s1.nextLine();
	System.out.println("Please enter the no.of rows to delete: ");
	int u4 = s1.nextInt();
	String u22[]=new String[u4];
	System.out.println("\n Please enter the base-column values used to delete(same as table-names sequence): ");
	for (int j=0;j<u4;j++) {
	u22[j]	= s1.next();
	}
	System.out.println("\nPlease find the below queries: ");
	for (int k=0;k<u4;k++) {
		System.out.println("delete from " +u1+ " where " +u3+ "='"+u22[k]+"';" );
	}

}
	static void queryHelp() {
		Scanner s1= new Scanner(System.in);
		int s=s1.nextInt();
		System.out.println("Enter the values or copy paste from the excel (column only):");
		String h[]=new String[s];
		Scanner s2= new Scanner(System.in);
		for (int i=0;i<s;i++) {
			h[i]=s2.nextLine();
		}
		for (int i=0;i<s;i++) {
			if (i<s-1) {
			System.out.println("'"+h[i]+"',");
		} else {System.out.print("'"+h[i]+"'; ");}
		}
	}
	static void selectQuery() {Scanner general= new Scanner(System.in); Scanner non_general= new Scanner(System.in);
	System.out.println("Please enter base table name to use after the 'from'(alias name addition will be much better):");
	String base_table=general.nextLine();
	System.out.println("Please enter the count of tables to join: ");
	int numOfTables=general.nextInt();
	String table_names[]= new String[numOfTables];
	String join_type[]= new String[numOfTables];
	String condition_[]=new String[numOfTables];
	for (int i=0;i<numOfTables;i++) {
		System.out.println("Please enter the table-"+(i+1)+" to add as a join(alias name addition will be much better):");
		table_names[i]=non_general.nextLine();
		System.out.println("Please enter the type of join for table-"+(i+1)+"(in proprt syntax):");
		join_type[i]=non_general.nextLine();
		System.out.println("Please enter the condition to join the above table/s: ");
		condition_[i]=non_general.nextLine();
	}
	System.out.println("SELECT (colums here)\nFROM "+base_table);
	for (int i=0;i<numOfTables;i++) {
		System.out.println(join_type[i]+" "+table_names[i]+" ON "+condition_[i]);
	}
	System.out.println("\nPlease enter the Column names to be given after 'select' with ',' seperation, from the above conditions: ");
	String columns_=non_general.nextLine();
	System.out.println("Please enter the conditions to use after the 'where' with the alias names(if mentioned with the tables): ");
	String where_cond=non_general.nextLine();
	System.out.println("\nThe final query:\n");
	System.out.println("SELECT "+columns_+"\nFROM "+base_table);
	for (int i=0;i<numOfTables;i++) {
		System.out.println(join_type[i]+" "+table_names[i]+" ON "+condition_[i]);
	}
	System.out.println("WHERE "+where_cond+" ;");
}
}
