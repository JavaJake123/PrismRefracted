package network.darkhelmet.prism.actions.entity;

import network.darkhelmet.prism.utils.MiscUtils;
import org.bukkit.Registry;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.entity.ZombieVillager;

public class ZombieVillagerSerlializer extends EntitySerializer {
    protected String profession = null;

    @Override
    protected void serializer(Entity entity) {
        profession = ((ZombieVillager) entity).getVillagerProfession().name().toLowerCase();
    }

    @Override
    protected void deserializer(Entity entity) {
        ((ZombieVillager) entity).setVillagerProfession(MiscUtils.getEntityType(profession, Villager.Profession.FARMER, Registry.VILLAGER_PROFESSION));
    }

    @Override
    protected void niceName(StringBuilder sb, int start) {
        if (profession != null) {
            sb.insert(start, MiscUtils.niceName(profession)).insert(start + profession.length(), ' ');
        }
    }
}
