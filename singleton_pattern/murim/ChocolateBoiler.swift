//
//  ChocolateBoiler.swift
//  singleton
//
//  Created by TOBO WORLD on 2022/08/13.
//

import Foundation

class ChocolateBoiler {
    static let shared = ChocolateBoiler()
    
    var empty : Bool = true
    var boiled : Bool = false
    
    func fill() {
        print("재료가 채워집니다.")
        if(isEmpty()){
            empty = false
            boiled = false
        }
    }
    
    func drain() {
        print("물을 끓입니다.")
        if(!isEmpty() && isBoiled()){
            empty = true
        }
        
    }
    
    func isEmpty() -> Bool {
        return empty
    }
    
    func isBoiled() -> Bool {
        return boiled
    }
}
