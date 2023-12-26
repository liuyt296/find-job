package life.majiang.community.cache;

import life.majiang.community.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by codedrinker on 2019/6/5.
 */
public class TagCache {
    public static List<TagDTO> get() {
        List<TagDTO> tagDTOS = new ArrayList<>();

        TagDTO server = new TagDTO();
        server.setCategoryName("女王推荐");
        server.setTags(Arrays.asList("优质女S", "情侣主"));
        tagDTOS.add(server);

        TagDTO program = new TagDTO();
        program.setCategoryName("点评女王");
        program.setTags(Arrays.asList("宝藏", "会玩", "性价比高", "不会玩", "身材好", "年轻", "素人"));
        tagDTOS.add(program);

        TagDTO framework = new TagDTO();
        framework.setCategoryName("交流心得");
        framework.setTags(Arrays.asList("女S", "夫妻"));
        tagDTOS.add(framework);

        return tagDTOS;
    }

    public static String filterInvalid(String tags) {
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = get();

        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> StringUtils.isBlank(t) || !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }

    public static void main(String[] args) {
        int i = (5 - 1) >>> 1;
        System.out.println(i);
    }
}
