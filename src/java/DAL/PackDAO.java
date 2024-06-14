package DAL;

import Models.Pack;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PackDAO extends DBContext {

    public List<Pack> getAllPacks() {
        List<Pack> packs = new ArrayList<>();
        String sql = "SELECT * FROM Pack";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Pack pack = new Pack(
                        rs.getInt("packID"), 
                        rs.getString("packName"),
                        rs.getString("packType"),
                        rs.getString("description"),
                        rs.getDouble("price")
                );
                packs.add(pack);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packs;
    }

    public Pack getPackByID(String packID) {
        Pack pack = null;
        String sql = "SELECT * FROM Pack WHERE packID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, packID);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    pack = new Pack(
                            rs.getInt("packID"), 
                            rs.getString("packName"),
                            rs.getString("packType"),
                            rs.getString("description"),
                            rs.getDouble("price")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pack;
    }
}
