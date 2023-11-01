workspace 'app_client_ios/app_client.xcworkspace'
platform :ios, '14.0'

#Dependencies version
#TODO

#Dependencies Path
#TODO
def pods_dependencies
  #pod 'SwiftDate', :git=> 'https://github.com/malcommac/SwiftDate.git', :tag => '7.0.0'
  #pod 'SwifterSwift/SwiftStdlib', :git=> 'https://github.com/SwifterSwift/SwifterSwift.git', :tag => '5.3.0'
end


#Target configuration
target 'app_client' do
  project 'app_client_ios/app_client.xcodeproj'
  use_frameworks!
  
#  pod 'app_client_shared', :path => 'app_client_shared'
  
  
end

target 'lib_ios_core' do
  project '../../libs/lib_ios/lib_ios_core/lib_ios_core.xcodeproj'
  use_frameworks! #:linkage => :static
    
    
end

target 'lib_ios_ui_core' do
  project '../../libs/lib_ios/lib_ios_ui_core/lib_ios_ui_core.xcodeproj'
  use_frameworks! #:linkage => :static
    
    
end

target 'lib_ios_ui_cpt' do
  project '../../libs/lib_ios/lib_ios_ui_cpt/lib_ios_ui_cpt.xcodeproj'
  use_frameworks! #:linkage => :static
    
    
end

target 'lib_ios_app_core' do
  project '../../libs/lib_ios/lib_ios_app_core/lib_ios_app_core.xcodeproj'
  use_frameworks! #:linkage => :static
    
    
end


