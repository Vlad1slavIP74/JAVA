/*
* %W% %E% Firstname Lastname
*
* Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
*
* This software is the confidential and proprietary information of Sun
* Microsystems, Inc. ("Confidential Information"). You shall not
* disclose such Confidential Information and shall use it only in
* accordance with the terms of the license agreement you entered into
* with Sun.
*
* SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
* THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
* TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
* PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
* ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
* DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
*/

package LAB4;

import java.util.*; 
import java.lang.*; 
import java.io.*; 

/**
* Class description goes here.
*
* @version
1.10 04 Oct 2019
* @author
Firstname Lastname
*/
public class LAB4 {
    public static void main(String[] args) {
    LAB4 task1 = new LAB4();
    SportEquipment[] sportEquipmentArr = task1.create();

    for (int i=0; i<sportEquipmentArr.length; i++) 
            System.out.println(sportEquipmentArr[i]);
    
    System.out.println("\nSorted by price");
    
    Arrays.sort(sportEquipmentArr, new SortByPrice());
    for (int i=0; i<sportEquipmentArr.length; i++) 
            System.out.println(sportEquipmentArr[i]);
    Arrays.sort(sportEquipmentArr, new SortByType());
    System.out.println("\nSorted by type");
    for (int i=0; i<sportEquipmentArr.length; i++) 
            System.out.println(sportEquipmentArr[i]);
    }
    /**
    * ...method Сreate documentation comment...
    */
    public SportEquipment[] create() {
        SportEquipment football = new SportEquipment("football", 1000, 600, "protection", "plastic");
        SportEquipment basketball = new SportEquipment("basketball", 100, 400, "protection", "tissue");
        SportEquipment swimming = new SportEquipment("basketball", 500, 200, "protection", "tissue");

        return new SportEquipment[] {football, basketball, swimming};
    }
    /**
    * ...method Sort documentation comment...
    */
    public void sort(SportEquipment[] sportEquipment) {
        Arrays.sort(sportEquipment, new SortByPrice());
    }
}
