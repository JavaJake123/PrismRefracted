package network.darkhelmet.prism.actions.entity;

import network.darkhelmet.prism.utils.MiscUtils;
import org.bukkit.Registry;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Entity;

public class CatSerializer extends EntitySerializer {
    protected String var = null;

    @Override
    protected void serializer(Entity entity) {
        var = ((Cat) entity).getCatType().name().toLowerCase();
    }

    @Override
    protected void deserializer(Entity entity) {
        Cat.Type type = MiscUtils.getEntityType(var, Cat.Type.ALL_BLACK, Registry.CAT_VARIANT);
        ((Cat) entity).setCatType(type);
    }

    @Override
    protected void niceName(StringBuilder sb, int start) {
        if (var != null) {
            sb.insert(start, MiscUtils.niceName(var)).insert(start + var.length(), ' ');
        }
    }
}
