/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontintaytto.junk;

/**
 * Tämä on väliaikainen luokka, jonne on vain tallennettu
 * algoritmi, jolla ohjelma toteutetaan
 * 
 * Lähde: http://www.cs.ukzn.ac.za/publications/erick_dube_507-034.pdf 
 *
 * @author X5DAD
 */
public class Algoritmi {
    
    
////Best Fit
//The Best Fit algorithm packs an item in a bin, which is
//the fullest among those bins in which the item fits.
//More specifically:
//Items are packed one at a time in given order.
//To determine the bin for an item, first determine set B of
//containers into which the item fits.
//If B is empty, then start a new bin and put the item into
//this new bin.
//Otherwise, pack the item into the bin of B that has least
//available capacity.
//    
//    
//    
//    Decide on a packing direction. Each bin has three
////directions in which to pack, a width (or x) direction, a
//height (or y) direction, a depth (or z) direction. Pack one
//bin at a time.
    
    
//We first choose a pivot point. The pivot is an (x, y, z)
//coordinate which represents a point in a particular 3D bin
//at which an attempt to pack an item will be made. The
//back lower left corner of the item will be placed at the
//pivot. If the item cannot be packed at the pivot position
//then it is rotated until it can be packed at the pivot point
//or until we have tried all 6 possible rotation types. If after
//rotating it, the item still cannot be packed at the pivot
//point, then we move on to packing another item and add
//the unpacked item to a list of items that will be packed
//after an attempt to pack the remaining items is made. The
//first pivot in an empty bin is always (0,0,0).
    
//    if (binWidth is smaller than binHeight
//and binDepth) then
//    {
//    packByWidth=true
//    packByHeight=false;
//    }
//else if (binDepth is smaller than
//binHeight and binWidth) then
//    {
//    packByWidth=false
//    packByHeight=false //both false
//    implies pack by depth
//    }
//else if (binHeight is smaller than
//binWidth and binDepth) then
//
//    {
//    packByWidth=false
//    packByHeight=true
//    }
//
//notPacked=Items
//
//do
//    {
//    toPack=notPacked
//    notPacked={} //clear notPacked
//
//    Create a new bin called currentBin
//    and check whether the item toPack[0]
//    is able to fit in this bin at
//    position (x,y,z)=(0,0,0).
//    if toPack[0] does not fit then
//    rotate it (over the six rotation
//    types) until it fits and pack it
//    into this bin at postion (0,0,0).
//    
//    for i=1 to (size of toPack-1) do
//        {
//        currentItem=toPack[i]
//        fitted=false
//        for p=0 to 2 do
//            {
//            k=0
//            d while (k < number of items in
//            currentBin) and (not fitted)
//                {
//                binItem=kth item in currentBin
//                if (packByWidth) then
//                    pivot=p
//                else if (packByHeight) then
//                    switch (p)
//                    {
//                    compute pivot p for height
//                    }
//                else //pack by depth
//                    switch (p)
//                    {
//                    compute pivot p for depth
//                    }
//                switch (pivot)
//                {
//                case 0 : Choose (pivotX, pivovY,
//                pivotZ ) as the back lower
//                right r i
//                    break
//                corne of b nItem
//                case 1 : Choose (pivotX, pivovY,
//                pivotZ ) as the front lower
//                left corner of binItem
//                    break
//                case 2 : Choose (pivotX, pivovY,
//                pivotZ ) as the back Upper
//                left corner of binItem
//                    break
//                }
//                if (currentItem can be packed
//                in currentBin at
//                position(pivotX, pivotY
//                ,pivotZ ) ) then
//                {
//                Pack currentItem into
//                currentBin at position
//                (pivotX, pivotY ,pivotZ).
//                fitted=true
//                }
//                else
//                { // try rotating item
//                do Rotate currenItem
//                while (currentItem cannot be
//                packed in currentBin at
//                position(pivotX,pivotY) )
//                and (not all
//                rotations for currentItem
//                checked)
//
//                if (currentItem can be packed
//                in currentBin at
//                position(pivotX, pivotY ,
//                pivotZ) ) then
//                {
//                    Pack currentItem into
//                    currentBin at position
//                    (pivotX, pivotY ,pivotZ).
//                    fitted=true     
//                }
//                else
//                    Restore currentItem to
//                    its original rotation type
//                }
//                if (not fitted) then
//                    Add currentItem to the list
//                    notPacked
//                }
//            }   
//        }
//} while notPacked has at least one
//Item in it (*i.e. notPacked is
    
}
