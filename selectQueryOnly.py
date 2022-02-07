base_table=input("Please enter the base-table name:(to use after 'from') ");
no_of_tables=int(input("Please enter no.of.tables to join, other than the base table: "));
list_name=[];
join_type=[];
condition=[];
column_name=[];
for i in range(0,no_of_tables):
    list_ele=input("Please enter the next table name(if needed alias name also, with single space gap only): ");
    type_ele=input("Please enter the type of join in syntax for this table: ");
    condition_ele=input("Please enter the condition linking with the above table/s, for joininig:(check the syntax properly): ")
    list_name.append(list_ele);
    join_type.append(type_ele);
    condition.append(condition_ele);
column_count=int(input("Please enter the number of columns required from the above tables to display:"))
for i in range(0,column_count):
    column_ele=input("Please enter the column names to get displayed:(check the syntax properly and if alias name is required, mention here with an extension 'as')" );
    column_name.append(column_ele);

print("\n");
print("Please check the below partial query: ")
print("SELECT ");
for i in range(0,column_count):
    print(column_name[i]+", ");
print("FROM "+base_table);
for i in range(0,no_of_tables):
    print(join_type[i]+" "+list_name[i]+" ON "+condition[i]);
    
where_initial=input("Is the above part of the query has everything you need?(yes/no): ");
print("Final Query: ")
print("\n");
if (where_initial=='yes'):
    where_condition=input("Please enter the conditions(in syntax) to be given after 'where', based on the above tables: ")
    print("SELECT ");
    for i in range(0,column_count):
        print(column_name[i]+", ");
    print("FROM "+base_table);
    for i in range(0,no_of_tables):
        print(join_type[i]+" "+list_name[i]+" ON "+condition[i]);
    
    print("WHERE "+where_condition);
else:print("Human error detected. Please rerun and try again");
