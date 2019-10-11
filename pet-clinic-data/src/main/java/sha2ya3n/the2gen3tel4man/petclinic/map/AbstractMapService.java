package sha2ya3n.the2gen3tel4man.petclinic.map;

import sha2ya3n.the2gen3tel4man.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }else{
            throw new RuntimeException("object can not be found");
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void deleteByObject(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) + 1;
        }catch (RuntimeException e){
            nextId = 1L;
        }

        return nextId;

    }


//    T findById(ID id) {
//        return map.get(id);
//    }
//
//    T save(ID id, T object){
//        for(int i=0; i<map.size(); i++){
//            if(!map.containsValue(object)){
//                map.put(id, object);
//                return object;
//            }
//        }
//        return null;
//    }
//
//    Set<T> findAll(){
//        return new HashSet<>(map.values());
//    }
//
//    void removeByObject(T object){
//        for(int i=0; i<map.size(); i++){
//            if(map.containsValue(object)){
//                map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
//                break;
//            }
//        }
//    }
//
//    void removeById(ID id){
//        for(int i=0; i<map.size(); i++){
//            if(map.keySet().contains(id)){
//                map.remove(id);
//            }
//        }
//    }
}

