//
//  main.swift
//  singleton
//
//  Created by TOBO WORLD on 2022/08/13.
//

import Foundation

func main() {
    // 초콜렛 끓이기
    let choco = ChocolateBoiler.shared
    choco.fill()
    choco.drain()
    
    // 마스크 주문하기
    let mask = MaskFactory.shared
    
    // 원하는 마스크 양 주문
    print("발주할 마스크 양을 입력해주세요")
    let str : String = readLine() ?? "0"
    mask.order(orderNum: Int(str) ?? 0)
    mask.orderCheck()
    
    // 마스크 공장 가동
    mask.make(completion: {
        print("마스크 제작이 완료되었습니다. 가져가세요.")
    })
    
    // 공장 초기화
    mask.reset()
}

class MaskFactory {
    static let shared = MaskFactory()
    
    private var orderAmount = 0
    private var complete = false
    
    func order(orderNum : Int){
        orderAmount = orderNum
    }
    
    func orderCheck(){
        print("주문한 마스크 수 : " + String(orderAmount))
    }
    
    func make(completion : () -> Void ){
        for maskNum in 0...orderAmount {
            if(maskNum % 5 == 0 || maskNum == orderAmount){
                print(String(maskNum) + "번째 제작 완료")
            }
            
            if(maskNum == orderAmount){
                completion()
            }
        }
    }
    
    func isComplete() -> Bool{
        return complete
    }
    
    func reset(){
        orderAmount = 0
        complete = false
    }
}

main()
