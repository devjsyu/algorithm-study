### analysis

#### Naive Approach
- nums1와 nums2의 모든 pair를 생성한다.
- 총 pair 개수: N * M
- 모든 pair를 min heap에 저장하는 경우:
  - Time: $O(NM*logNM)$
  - Space: $O(NM)$
- 크기 K의 heap만 유지하는 경우:
  - Time: $O(NMlogK)$
  - Space: $O(K)$

#### K-way Merge + Min Heap
- nums1, nums2가 non-decreasing order로 정렬되어 있다는 점을 활용한다.
- nums2[j]를 고정하면 다음의 하나의 sorted sequence가 된다:
  - (nums1[0], nums2[j])
    (nums1[1], nums2[j])
    (nums1[2], nums2[j])
    ...
- 각 sorted sequence의 가장 작은 미처리 후보(frontier)만 min heap에 유지한다.
- min pair를 poll하면, 해당 sequence의 다음 pair만 heap에 추가한다.
- 모든 pair를 생성할 필요가 없다.

#### Optimization
- 결과는 최대 K개만 필요하므로 처음부터 모든 sequence를 heap에 넣을 필요가 없다.
- 초기 heap 크기: min(K, nums2.length)

#### Complexity
- H = min(K, nums2.length)
- Time: $O(KlogH)$, 초기 heap 삽입까지 엄밀히 포함하면 $O(HlogH + KlogH)$
- Simplified: $O(KlogK)$
- Auxiliary Space: $O(H)$

### key takeaway
> 여러 개의 sorted sequence에서 전체적으로 가장 작은 K개를 구해야 한다면, 모든 원소를 합치지 말고 각 sequence의 현재 최소 후보만 min heap에 유지하는 K-way merge를 고려한다.