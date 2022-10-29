package onboarding;


import java.util.*;
public class Problem7 {
    private static final HashMap<String, Integer> userHash = new HashMap<>();

    /**
     * <div> 사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때,
     * <b>미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명</b>을 리턴합니다. </div>
     * <br>
     *
     * 친구 추천 알고리즘 규칙 :
     *
     *  <ol>
     *      <li>사용자와 함께 아는 친구의 수 = <b>10점</b></li>
     *      <li>사용자의 타임 라인에 방문한 횟수 = <b>1점</b></li>
     *  </ol>
     *
     * <br>
     *
     * 세부 기능 목록 :
     *
     *  <ol>
     *      <li>친구 관계를 자료구조(그래프)로 표현</li>
     *      <li>BFS 알고리즘을 사용해서 해쉬에 점수를 적재</li>
     *      <li>추천 친구 정보 저장</li>
     *      <li>유효성 검사</li>
     *  </ol>
     *
     * @implNote 양방향 그래프에서 BFS를 수행하되 2촌의 방문횟수(함께 아는 친구)를 저장
     * @param user 사용자 아이디
     * @param friends 친구 관계 정보 [src, dest]의 리스트
     * @param visitors 사용자 타임 라인 방문 기록
     * @return 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬된  사용자의 최대 5명 {@code List}
     *
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<? extends List<Integer>> getGraph(List<List<String>> friends) {
        List<List<Integer>> graph = new ArrayList<>();
        HashSet<String> users = getUserSet(friends);
        setUserIndex(users);
        for(int i = 0; i < users.size(); i++) graph.add(new ArrayList<>());

        for(List<String> edge : friends) {
            String src = edge.get(0);
            String dest = edge.get(1);

            int srcIndex = getUserIndex(src);
            int destIndex = getUserIndex(dest);

            graph.get(srcIndex).add(destIndex);
            graph.get(destIndex).add(srcIndex);
        }

        return graph;
    }
    
    private static int getUserIndex(String target) {
        return userHash.get(target);
    }

    private static void setUserIndex(HashSet<String> users) {
        int index = 0;
        for (String key : users) {
            userHash.put(key, index++);
        }
    }

    private static HashSet<String> getUserSet(List<List<String>> users) {
        HashSet<String> set = new HashSet<>();
        users.forEach(set::addAll);
        return set;
    }

}
