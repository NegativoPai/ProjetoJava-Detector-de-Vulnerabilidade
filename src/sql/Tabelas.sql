public void criarTabela(){
   String sql = "create table if not exists usuarios ("
                + "id integer primary key autoincrement,"
                + "nome text not null,"
                + "email text not null unique,"
                + "senha text not null"
                + ");";

            create table if not exists scan_results (
                   id integer primary key autoincrement,
                   target text not null,
                   status_code integer,
                   message text,
                   timestamp datetime default current_timestamp
            );

    try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
       stmt.execute();
    } catch (SQLException e){
        e.printStackTrace();
    }
}
