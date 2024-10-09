# Readable Code

## 고민 및 질문 내용
1. StudyCafeLockerPass는 어떻게 관리해야 할까?
클라이언트 입장에서 사물함에 대한 정보까지 StudyCafePass가 맡아서 알려주면 좋겠다는 판단으로 리팩토링을 진행했습니다.
StudyCafePass 필드에 StudyCafeLockerPass를 바로 참조할지, 여러 정보들을 조합해서 StudyCafeLockerPass에 메시지를 던지는 방향으로 할지 고민이 많이 됐습니다.
일반적으로, 어떤 방향으로 코드를 작성해야 하는지 조언을 구하고 싶습니다!

2. 파라미터는 적을수록 좋을까요?
StudyCafePass 생성자 파라미터가 너무 많다는 생각이 들어서 줄이고 싶은 욕구가 많이 생겼지만, 어떻게 줄여야 할까 방법이 잘 떠오르지 않았습니다.
price, discountRate 를 묶어서 ValueObject를 만들까? 필드를 최대한 줄일까? 등의 생각을 하다가 손대지 못했습니다.
파라미터를 줄일 수 있는 방법으로 더 고민하는 과정이 필요할지 궁급합니다!
