/*
 *  Copyright 2016 by Simba Project                                   
 *                                                                            
 *  Licensed under the Apache License, Version 2.0 (the "License");           
 *  you may not use this file except in compliance with the License.          
 *  You may obtain a copy of the License at                                   
 *                                                                            
 *    http://www.apache.org/licenses/LICENSE-2.0                              
 *                                                                            
 *  Unless required by applicable law or agreed to in writing, software       
 *  distributed under the License is distributed on an "AS IS" BASIS,         
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
 *  See the License for the specific language governing permissions and       
 *  limitations under the License.                                            
 */

package org.apache.spark.sql.index

import org.apache.spark.sql.catalyst.InternalRow

/**
 * Created by dong on 1/15/16.
 * Encapsulated HashMap Index
 */
class HashMapIndex[T] extends Index with Serializable {
  var index = new java.util.HashMap[T, Int]()
}

object HashMapIndex {
  def apply[T](data: Array[(T, InternalRow)]): HashMapIndex[T] = {
    val res = new HashMapIndex[T]
    for (i <- data.indices) {
      res.index.put(data(i)._1, i)
    }
    res
  }
}
