package db;

public class ConstantQueries {
	
	 private static final class TEMPLATE {
	        private static final String SELECT_ALL = "SELECT * FROM %s";
	        private static final String SELECT_WHERE_COL = "SELECT * FROM %s where %s=?";
	        private static final String SELECT_WHERE_NOCOL = "SELECT * FROM %s where %s NOT IN ?";
	        private static final String DELETE_ALL = "DELETE FROM %s";
	        private static final String DELETE_WHERE_COL = "DELETE FROM %s WHERE %s=?";
	        private static final String INSERT = "INSERT INTO %s VALUES(%s)";
	        private static final String UPDATE = "UPDATE %s SET %s WHERE %s";
	    }

	   public static final class USERS {
	        private static final String tableName = "Users";
	        // columns
	        public static final String COL_ID = "userID";
	        public static final String COL_PASSWORD = "password";
	        public static final String COL_DATE = "registerDate";
	        
	        public static final String SELECT_ALL = String.format(TEMPLATE.SELECT_ALL, tableName);
	        public static final String SELECT_BY_ID = String.format(TEMPLATE.SELECT_WHERE_COL, tableName, COL_ID);
	        public static final String DELETE_ALL = String.format(TEMPLATE.DELETE_ALL, tableName);
	        public static final String DELETE_BY_ID = String.format(TEMPLATE.DELETE_WHERE_COL, tableName, COL_ID);
	        public static final String INSERT = String.format(TEMPLATE.INSERT, tableName,
	                /* number of columns */ "?,?,?");
	   }
}
