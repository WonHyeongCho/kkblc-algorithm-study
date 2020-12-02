### 스트림(Stream)

> 스트림에서 꼭 알아야 할 것

1. 기존에 사용하는 방식 [Collection.sort(), Arrays.sort()]는
List를 정렬할 때는 Collection.sort(), 배열을 정렬을 할 떄는 Arrays.sort()로 정렬을 했다. 데이터 타입이 서로 달라도 정렬을 해줄 수 있는 것이 Stream이다.

```java
        //List일 때
        List<Integer> list = new ArrayList<>();

        int temp = -1;//임시값을 -1로 초기화
        for (int i: arr) {
            if(temp != i){
                temp = i;
                list.add(temp);
            }

        }
        //람다 표현식  여기서는 그대로 사용하기 위해 i->i로 사용하는 방식
        int [] answer = list.stream().
        mapToInt(i->i).toArray();

        answer = [1, 3, 0, 1]
```

```java
        //만일  mapToInt를 쓰지 않는다면
        int [] answer = list.stream().toArray();
        //int stream이 안된 상태에서 array변환
        java.lang.Object[] cannot be converted to int[] 에러가 나온다.
```
